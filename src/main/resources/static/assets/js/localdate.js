// 현재 시간을 가져와서 'YYYY-MM-DD HH:MM' 형식으로 변환하는 함수
function getFormattedTimestamp() {
    var currentTime = new Date();
    var year = currentTime.getFullYear();
    var month = String(currentTime.getMonth() + 1).padStart(2, '0');
    var day = String(currentTime.getDate()).padStart(2, '0');
    var hours = String(currentTime.getHours()).padStart(2, '0');
    var minutes = String(currentTime.getMinutes()).padStart(2, '0');
    var formattedTime = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
    return formattedTime;
  }
  
  // 요소에 동적으로 시간 데이터를 설정
  var nicknameElement = document.querySelector('.rpboard-nickname');
  var timestamp = getFormattedTimestamp();
  nicknameElement.setAttribute('data-timestamp', timestamp);
  