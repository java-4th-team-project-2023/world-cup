
// var options = [
//     "옵션1",
//     "옵션2",
//     "옵션3",
//     "옵션4"
//     ];
  
//   var currentRound = 0; // 현재 라운드
//   var winners = []; // 각 라운드에서의 승자들
  
//   function startGame() {
//     var gameDiv = document.getElementById("game");
  
//     // 게임이 시작되면 첫 번째 라운드를 표시
//     displayRound(gameDiv);
//   }
  
//   function displayRound(gameDiv) {
//     gameDiv.innerHTML = "";
  
//     if (currentRound >= options.length - 1) {
//       // 게임이 종료되었을 때
//       var winner = winners[winners.length - 1];
//       gameDiv.innerHTML = "<h2>우승자: " + winner + "</h2>";
//     } else {
//       // 현재 라운드에서의 옵션들을 가져옴
//       var currentOptions = [];
//       var startIndex = Math.pow(2, currentRound);
//       var endIndex = Math.pow(2, currentRound + 1);
//       for (var i = startIndex; i < endIndex; i++) {
//         currentOptions.push(options[i]);
//       }
  
//       var roundHtml = "<h2>라운드 " + (currentRound + 1) + "</h2>";
//       for (var j = 0; j < currentOptions.length; j += 2) {
//         var option1 = currentOptions[j];
//         var option2 = currentOptions[j + 1];
  
//         roundHtml += "<p>1. " + option1 + "</p>";
//         roundHtml += "<p>2. " + option2 + "</p>";
//       }
  
//       gameDiv.innerHTML = roundHtml;
  
//       // 다음 라운드로 진행하기 위해 이벤트 리스너 추가
//       gameDiv.addEventListener("click", nextRound);
//     }
//   }
  
//   function nextRound() {
//     var selectedOption = event.target.innerHTML;
  
//     winners.push(selectedOption);
//     currentRound++;
  
//     var gameDiv = document.getElementById("game");
//     displayRound(gameDiv);
//   }
  
//   // 게임 시작
//   startGame();
  

// 16강, 8강, 4강, 결승 으로 이어지도록 만들기 

var options = [
  // 16강
  ["옵션1", "옵션2"],
  ["옵션3", "옵션4"],
  ["옵션5", "옵션6"],
  ["옵션7", "옵션8"],
  ["옵션9", "옵션10"],
  ["옵션11", "옵션12"],
  ["옵션13", "옵션14"],
  ["옵션15", "옵션16"],

  // 8강
  ["", ""],
  ["", ""],
  ["", ""],
  ["", ""],

  // 4강
  ["", ""],
  ["", ""],

  // 결승
  ["", ""]
];

var currentRound = 0;
var winners = [];

function startGame() {
  displayRound();
}

function displayRound() {
  var gameDiv = document.getElementById("game");
  gameDiv.innerHTML = "";

  if (currentRound >= options.length) {
    var winner = winners[winners.length - 1];
    gameDiv.innerHTML = "<h2>우승자: " + winner + "</h2>";
  } else {
    var currentOptions = options[currentRound];

    var roundHtml = "<h2>라운드 " + (currentRound + 1) + "</h2>";
    for (var i = 0; i < currentOptions.length; i++) {
      roundHtml += "<p onclick='selectOption(this)'>" + currentOptions[i] + "</p>";
    }

    gameDiv.innerHTML = roundHtml;
  }
}

function selectOption(option) {
  var selectedOption = option.innerHTML;

  winners.push(selectedOption);
  currentRound++;

  updateOptions();

  displayRound();
}

function updateOptions() {
  var nextOptions = [];

  if (currentRound >= 8 && currentRound < 12) {
    nextOptions.push(winners[currentRound - 8]);
    nextOptions.push(winners[currentRound - 7]);
  } else if (currentRound >= 12 && currentRound < 14) {
    nextOptions.push(winners[currentRound - 8]);
    nextOptions.push(winners[currentRound - 6]);
  } else if (currentRound === 14) {
    nextOptions.push(winners[currentRound - 8]);
    nextOptions.push(winners[currentRound - 5]);
  }

  options[currentRound] = nextOptions;
}

// 게임 시작
startGame();


// 16강 -> 8강 -> 4강 -> 결승
// list에서 앞 뒤로 뺴오기
// 게임실행 후  winner 목록이 다시 목록이 되게 만들기
//  1개가 남으면 우승. 게임 완료

// options [

// //8강

// ];


winners = []; 




