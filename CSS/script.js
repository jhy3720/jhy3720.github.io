/**
* 
* 
* 
* 수직스크롤 발생 시 header태그 active 클래스 추가 및 삭제 
*/
(function(){
    const headerEl = document.querySelector("header");

    window.addEventListener("scroll",function(){
    
        scrollCheck();
        
    });
    
    function scrollCheck(){
    
        const browerScrollY = window.scrollY ? window.scrollY : window.pageYOffset;
    
        if(browerScrollY > 0){
    
            headerEl.classList.add('active');
    
         } else{
    
            headerEl.classList.remove('active');
    
        }
    
        console.log('scroll');
    }
})();


/**
 * 
 * 
 *  header버튼 클릭 시 이동
 */
const aniMove = function(selector){

    const target = document.querySelector(selector);

    const browerScrollY = window.scrollY;

    const targetScrollY = target.getBoundingClientRect().top + browerScrollY;

    window.scrollTo({top: targetScrollY, behavior:'smooth'});

}

const scrollMoveEl = document.querySelectorAll("[data-animation-scroll='true']");

console.log(scrollMoveEl)

for(let i=0; i< scrollMoveEl.length; i ++){

    scrollMoveEl[i].addEventListener("click",function(e){

        aniMove(this.dataset.target);

    });

}


