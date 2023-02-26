package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.entities.Code;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository){
        this.codeRepository = codeRepository;
    }

    public void update(Code code){
        if(code.isViewsRestrict() && code.getViews() >= 0){
            code.setViews(code.getViews() - 1);
            if(code.getViews() < 0){
                codeRepository.delete(code);
                return;
            }
        }
        if(code.isTimeRestrict() && code.getTime() >= 0){
            long originalTime = code.getOriginalTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            code.setTime(originalTime - ChronoUnit.SECONDS.between(LocalDateTime.parse(code.getDate(), formatter) , LocalDateTime.now()));
            if(code.getTime() < 0){
                codeRepository.delete(code);
                return;
            }

        }
        codeRepository.save(code);

    }

    public boolean IdExists(String id){
        return codeRepository.existsById(id);
    }

    public Code findCodeById(String id){
        Code idCode = codeRepository.findById(id).get();
        return idCode;
    }

    public void save(Code toSave){
        codeRepository.save(toSave);
    }

    public List<Code> getLatestCodes(){
        List<Code> allCodes = (List<Code>) codeRepository.findAll();
        List<Code> latestCodes = new ArrayList<>();
        int total = 10;
        for(int i = allCodes.size()-1; i >= 0; i--){
            Code code = allCodes.get(i);
            if(code.isTimeRestrict() || code.isViewsRestrict()){
                continue;
            }
            else{
                latestCodes.add(code);
                total --;
                if(total == 0){
                    break;
                }
            }
        }
        return latestCodes;
    }

}