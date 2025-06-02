<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${documentName}</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        .navigation {
            display: flex;
            justify-content: space-between;
            padding: 10px 20px;
            font-size: 18px;
        }
        .home-link {
            font-size: 18px;
            text-decoration: none;
            user-select: none;
        }
        .home-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div id="pageCounter" class="page-counter">1/${documentPages?size}</div>

<img id="imageDisplay" src="data:image/png;base64,${documentPages[0]}" alt="Page">

<div class="navigation">
    <button id="prevBtn">last page</button>
    <button id="nextBtn">next page</button>
</div>

<a href="/document-list-without" class="home-link">home</a>

<script>
    const images = [<#list documentPages as img>"${img?js_string}"<#if img_has_next>, </#if></#list>];
    let index = 0;

    const imgElement = document.getElementById('imageDisplay');
    const prevBtn = document.getElementById('prevBtn');
    const nextBtn = document.getElementById('nextBtn');
    const pageCounter = document.getElementById('pageCounter');

    function updateImage() {
        imgElement.src = "data:image/png;base64," + images[index];
        pageCounter.textContent = index + 1+'/'+images.length;
        prevBtn.disabled = (index === 0);
        nextBtn.disabled = (index === images.length - 1);
    }

    prevBtn.addEventListener('click', () => {
        if (index > 0) {
            index--;
            updateImage();
        }
    });

    nextBtn.addEventListener('click', () => {
        if (index < images.length - 1) {
            index++;
            updateImage();
        }
    });

    updateImage();
</script>

</body>
</html>

