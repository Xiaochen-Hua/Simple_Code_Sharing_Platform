<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet"
              href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Latest</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
        <#list codeslist as code>
            <span id="date">${code.date}</span>
            <br>
            <pre>${code.code}</pre>
        </#list>
</body>
</html>