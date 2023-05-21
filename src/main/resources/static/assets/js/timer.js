

const btn = document.getElementById('btn');
const timer = document.querySelector('.timer');
const tim = setInterval(timeout, 1000);
let sec = 4;

function timeout() {
   sec--;
if(sec<=0){
 timer.textContent = '';  
clearInterval(tim);

}else {
    timer.textContent = sec;   
}

}



(function() {
    timeout();
})();

export{btn,timer,tim,timeout};