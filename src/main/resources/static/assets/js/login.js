const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

document.getElementById('sign-in-account').focus();

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});


const checkResultList = [false,false,false];

// 회원가입 아이디 검증

        //아이디 검사 정규 표현식
        const accountPattern = /^[a-zA-Z0-9]{4,14}$/;



        // 아이디 입력값 검증

        const $idInput = document.getElementById('reg_accountid');
        const $accChk = document.getElementById('accChk');
        $idInput.onkeyup = e => {
            const idValue = $idInput.value;
            // console.log(idValue);
            $accChk.textContent = 000;

            if(idValue.trim() === '') {
               
                $accChk.innerHTML = '<span style = "color: red">[아이디는 필수값 입니다!]</span>';
                checkResultList[0]= false;
            }else if(!accountPattern.test(idValue)) {
                
                $accChk.innerHTML = '<span style = "color: red">[4~14자의 영문, 숫자로 입력하세요!]</span>';
                checkResultList[0]= false;
            }else {
                fetch('/members/check?type=account&keyword='+idValue)
                .then(res => res.json())
                .then(flag => {
                    if(flag){
                        
                        $accChk.innerHTML = '<span style = "color: red">[아이디가 중복되었습니다!]</span>';
                         checkResultList[0] =false;
                        }else {
                        
                            $accChk.innerHTML = '<span style = "color: #D6E6F2">[사용가능한 아이디 입니다]</span>';
                        checkResultList[0] = true;
                    }
                })


                $accChk.innerHTML = '<span style = "color: #D6E6F2">[사용가능한 아이디 입니다]</span>';
                checkResultList[0]=true;
            }
        };





// 회원가입 이메일 검증
    // 이메일 검사 정규표현식
        const emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

        // 이메일 입력값 검증
        const $emailInput = document.getElementById('reg_email');
        const $emailChk = document.getElementById('emailChk');

        $emailInput.onkeyup = e => {

            const emailValue = $emailInput.value;
            // console.log(emailValue);

            if (emailValue.trim() === '') {
                
                $emailChk.innerHTML
                    = '<span style="color: red;">[이메일 필수값입니다!]</span>';
                    checkResultList[1] = false;

            } else if (!emailPattern.test(emailValue)) {
               
                $emailChk.innerHTML
                    = '<span style="color: red;">[이메일 형식을 지켜주세요~]</span>';
                    checkResultList[1] = false;
            // } else {

            //     fetch('' + )
            //         .then(res => res.json())
            //         .then(flag => {
            //             if (flag) { // 중복
                            
            //                 $emailChk.innerHTML
            //                     = '<span style="color: red;">[이메일이 중복되었습니다.]</span>';
            //                     checkResultList[1] = false;
                         } else {
                           
                            $emailChk.innerHTML
                                = '<span style="color: #D6E6F2;">[사용가능한 이메일입니다.]</span>';
                                checkResultList[1] = true;
                        }
                    // });
                // }
            };


// 회원가입 비밀번호 검증 (영문숫자조합 5자리 이상 10자리이하)
            const passwordPattern = /^(?=.*[a-zA-Z])(?=.*[0-9]).{5,10}$/; 

            const $pwInput = document.getElementById('reg_password');
            const $pwChk = document.getElementById('pwChk');

        $pwInput.onkeyup = e => {

            const pwValue = $pwInput.value;
            // console.log(pwValue);

            if (pwValue.trim() === '') {
                
                $pwChk.innerHTML
                    = '<span style="color: red;">[비밀번호는 필수값입니다!]</span>';
                    checkResultList[2] = false;
            } else if (!passwordPattern.test(pwValue)) {
             
                $pwChk.innerHTML
                    = '<span style="color: red;">[영문숫자조합 5자 이상 10자 이하]</span>';
                    checkResultList[2] = false;
            } else {

                
                $pwChk.innerHTML
                    = '<span style="color: #D6E6F2;">[사용가능한 비밀번호입니다.]</span>';
                    checkResultList[2] = true;
                
            }
        };

        // const serverMessage = '${msg}';
        // // console.log(serverMessage);

        // if(serverMessage =='') {
        //     alert('회원정보가 없습니다')
        // }else if(serverMessage == '') {
        //     alert('비밀번호가 틀렸습니다')
        // }





        document.getElementById('SignUpBtn').onclick = e =>{
        

            const $form = document.getElementById('signUpForm');

            if(!checkResultList.includes(false)) {
                $form.submit();
            }else{
               const $box = document.getElementById('container');
		        $box.classList.add('vibration');
            } 
            e.preventDefault();
		
        };
