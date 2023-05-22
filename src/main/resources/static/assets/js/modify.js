const $input = document.getElementById('modify-file');
const $changeimg= document.querySelector('.changeimg');

$changeimg.onclick = e => {
    $input.click();
}

$input.onchange = e => { 
    const file = $input.files[0];
    console.log(file);

    const reader = new FileReader();
    
    reader.readAsDataURL(file);
    reader.onloadend = e => {
     const $imgTag = document.querySelector('.img');
     $imgTag.setAttribute('src', reader.result);
        
    }
};

