<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 20px;
        }
        .document-link {
            display: block;
            margin: 10px auto;
            width: fit-content;
            font-size: 18px;
            text-decoration: none;
        }
        .document-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<h1>Документы</h1>

<#list documentList as documentName>
    <a class="document-link" href="file/${documentName}/0">${documentName}</a>
</#list>

</body>
</html>

