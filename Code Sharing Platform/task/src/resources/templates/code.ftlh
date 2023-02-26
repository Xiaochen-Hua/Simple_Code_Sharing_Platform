<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <meta charset="UTF-8">
    <title>Code</title>
    <style>
        #load_date{
            color: green;
        }
        #code_snippet{
            width: 750px;
            border: 2px solid gray;
            background-color: lightgray;
        }
    </style>
</head>
<body>

<span id="load_date">${IdCode.getDate()}</span>
<br>
<#if IdCode.isViewsRestrict()>
    <span id="views_restriction">${IdCode.getViews()} more views allowed</span>
</#if>
<br>
<#if IdCode.isTimeRestrict()>
    <span id="time_restriction">The code will be available for ${IdCode.getTime()} seconds</span>
</#if>
<pre id="code_snippet"><code>${IdCode.getCode()}</code></pre>

</body>
</html>
