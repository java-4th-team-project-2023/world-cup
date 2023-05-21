

// 게임 제목 담기
const $gameName = document.querySelector('.info-title');
console.log($gameName.value);  




// 리스트 추가하는 버튼 
const $plusBtn = document.querySelector('.plusBtn');

$plusBtn.onclick = e => {
    addList();

};


// 사진 담을 리스트
// const imgList = [];

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
    // 첫번째 div 안에 input tag
    let $addinput = document.createElement('input');
    $addinput.setAttribute('id', 'addImg');
    $addinput.setAttribute('name', 'playerImgPath');
    $addinput.setAttribute('accept', 'image/*');
    $addinput.type = "file";
    $addDiv1.appendChild($addinput);
    // 첫번째 div 안에  button tag
    let $addButton = document.createElement('button');
    $addButton.setAttribute('class', 'changeimg');
    $addButton.setAttribute('type', 'button');
    $addButton.textContent = '사진등록';
    $addDiv1.appendChild($addButton);

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
    // 네번째 div 안에 input tag
    let $addinputName = document.createElement('input');
    $addinputName.setAttribute('id', 'playerName');
    $addinputName.setAttribute('name', 'playerName');
    $addinputName.setAttribute('type', 'text');
    $addDiv4.appendChild($addinputName);
    const $playerName = $addinputName.value;

    // 리스트 안에 네번째 div
    let $addDiv5 = document.createElement('div');
    $addlist.appendChild($addDiv5);
    // 네번째 div 안에 삭제 button
    let $addButton2 = document.createElement('button');
    $addButton2.setAttribute('id', 'delbtn');
    $addButton2.setAttribute('type', 'button');
    $addButton2.textContent = '삭제';
    $addDiv5.appendChild($addButton2);



    if ($addImg.currentSrc === '') {
        // console.log(this.files.currentSrc);
        $addDiv3.classList.add('invisible')
    }


    $addButton.onclick = e => {

        $addinput.click();

    }
    let selectedImg ='';

    $addinput.onchange = e => {
        const fileData = $addinput.files[0];
        console.log(fileData);

        const reader = new FileReader();
        reader.readAsDataURL(fileData);

        reader.onloadend = e => {
            // const $imgTag = document.querySelector('.img');
            selectedImg = $addImg.setAttribute('src', reader.result);
            $addDiv3.classList.remove('invisible');
            // imgList.push(selectedImg);
            // console.log(imgList.length);

              const playerList = {
            accountId: 'ff',
            gameName: $gameName,
            imgList: [{
                playerName: $playerName,
                playerImgPath: selectedImg.src
            }]
            
        }

        console.log(playerList);
    }

   

        $addButton2.onclick = e => {
            $addDiv5.parentElement.remove()
        }

      
        };
    
        
  


};
// 사진 등록할 때마다 등록사진 배열 증가 
// console.log(imgList.length);



// 사진을 동록하지 않은 경우 박스가 보이지 않음

// 저장하기 클릭시 inputtag 보이기.  

// 삭제버튼 클릭 시 리스트 삭제 






















// 삭제버튼 클릭시 리스트도 삭제 




// list 넣기 test
// 서버로 보낼 데이터
// const playerList = {
//     accountId: 'ff',
//     gameName: $gameName,
//     imgList: [{
//         playerName: $addinputName,
//         playerImgPath: selectedImg
//     }]

// };


const $save = document.querySelector('.saveBtn');



// playerList.imgList.push({playerName: '2', playerImgPath: '2'});
//     console.log(playerList);

// $save.onclick = e => {
//   // 이미지 정보를 담을 배열 생성
//   const imageList = [];

//   // 이미지 입력 항목들의 값을 가져와서 배열에 추가
//   const imageInputs = document.querySelector('img');
//   const imageUrl = imageInputs[i].currentSrc;
//   console.log(imageUrl);

//   for (let i = 0; i < imageInputs.length; i++) {
//       const imageUrl = imageInputs[i].currentSrc;
//       const imageName = imageInputs[i].querySelector('#playerName').value;
//       const imageInfo = {
//           url: imageUrl,
//           name: imageName
//       };
//       imageList.push(imageInfo);
//   }

//   console.log(imageList);
//   // 선택한 이미지 정보가 담긴 배열을 변수 imageList에 저장하여 활용할 수 있습니다.

//   // 여기에 선택한 값을 보내는 로직을 추가합니다.
//   // 예를 들어, 서버로 배열을 전송하는 AJAX 요청 등을 수행할 수 있습니다.
//   // 아래는 예시 코드입니다.
//   sendDataToServer(imageList);
//     }