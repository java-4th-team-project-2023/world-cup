// 리스트 추가하는 버튼
const $plusBtn = document.querySelector('.plusBtn');

$plusBtn.onclick = e => {
    addList();

};

function addList() {


    // 리스트 추가 
    const $contentUl = document.querySelector('.content-ul');

    let $addlist = document.createElement('li');
    $addlist.setAttribute('class', 'list-content');
    $contentUl.appendChild($addlist);
    // list 중 첫번째 div 생성
    let $addDiv1 = document.createElement('div');
    $addDiv1.setAttribute('class', 'img-container');
    $addlist.appendChild($addDiv1);
    // 첫번째 div 안에 input/button tag
    let $addinput = document.createElement('input');
    $addinput.setAttribute('class', 'addImg');
    $addinput.setAttribute('name', 'playerImgPath');
    $addinput.setAttribute('accept', 'image/*');
    $addinput.type = "file";
    $addDiv1.appendChild($addinput);
// 등록하기 버튼
    let $addButton = document.createElement('button');
    $addButton.setAttribute('class', 'changeimg');
    $addButton.setAttribute('type', 'button');
    $addButton.textContent = '사진등록';
    $addDiv1.appendChild($addButton);

    // 버튼 클릭시 인풋창 띄우기 
    $addButton.onclick = e => {
        $addinput.click();
    };


    // 두번째 div 태그 
    let $addDiv2 = document.createElement('div');
    $addlist.appendChild($addDiv2);
    // 두번째 div 태그 인에 div 생성 
    let $addDiv3 = document.createElement('div');
    $addDiv3.setAttribute('class', 'img-box');
    $addDiv2.appendChild($addDiv3);

    // 두번째 div 태그 인에 div 안에 이미지 나타낼 태그 생성
    let $addImg = document.createElement('img');
    $addImg.setAttribute('class', 'img');
    $addImg.setAttribute('name', 'img');
    $addDiv3.appendChild($addImg);


    // 리스트 안에 세번째 div
    let $addDiv4 = document.createElement('div');
    $addlist.appendChild($addDiv4);
    // 세번째 div 안에 input tag
    let $addinputName = document.createElement('input');
    $addinputName.setAttribute('class', 'playerName');
    $addinputName.setAttribute('name', 'playerName');
    $addinputName.setAttribute('type', 'text');
    $addDiv4.appendChild($addinputName);

    // 리스트 안에 네번째 div
    let $addDiv5 = document.createElement('div');
    $addlist.appendChild($addDiv5);
    // 네번째 div 안에 삭제 button
    addDelBtn($addDiv5);

    // 이미지 주소가 없으면 이미지 상자 나타나지 않음
    if ($addImg.currentSrc === '') {
        // console.log(this.files.currentSrc);
        $addDiv3.classList.add('invisible')
    }

    // console.log(document.querySelector('addImg').name);

    $addinput.onchange = e => {
        const fileData = $addinput.files[0];
        // console.log(fileData);

        const reader = new FileReader();
        reader.readAsDataURL(fileData);

        reader.onloadend = e => {
            $addImg.setAttribute('src', reader.result);
            $addDiv3.classList.remove('invisible');

        };


    };


}

// addList() 끝


// 삭제버튼 추가 및 삭제 기능

function addDelBtn($addDiv5) {
    let $delButton = document.createElement('button');
    $delButton.setAttribute('id', 'delbtn');
    $delButton.setAttribute('type', 'button');
    $delButton.textContent = '삭제';
    $addDiv5.appendChild($delButton);

    // 삭제하기
    $delButton.onclick = e => {
        $addDiv5.parentElement.remove()
    }

}


// save 버튼 누를 때 form 보내기  담아오기
const $save = document.querySelector('.saveBtn');
$save.onclick = e => {

    const $form = document.getElementById('form');
    $form.submit();

}
