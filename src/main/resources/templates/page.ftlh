<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${documentName}</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .image-container {
            flex-grow: 1;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .navigation {
            display: flex;
            justify-content: space-between;
            padding: 10px 20px;
            font-size: 18px;
        }
        .home-link {
            text-align: center;
            padding: 15px 0;
            font-size: 20px;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="image-container">
    <img src="data:image/png;base64,${documentPage}" alt="Page" style="max-width: 100%; max-height: 100%;">
</div>

<div class="navigation">
    <div>
        <#if pageNumber != 0>
            <a href="/file/${documentName}/${pageNumber - 1}">last page</a>
        </#if>
    </div>
    <div>
        <#if pageNumber != documentSize - 1>
            <a href="/file/${documentName}/${pageNumber + 1}">next page</a>
        </#if>
    </div>
</div>

<a class="home-link" href="/document-list">home</a>

</body>
</html>

