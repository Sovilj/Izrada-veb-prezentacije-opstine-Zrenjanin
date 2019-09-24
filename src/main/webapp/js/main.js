/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*---- Navbar menja pozadinu kada se desi hover na megamenu----*/
$(function () {
    $(".megamenu").hover(function () {
        $(".navbar-background").css('background', 'rgb(12,64,119)');

    }, function () {
        // reset pozadine

        $(".navbar-background").css('background', 'none');
        $(".navbar-background").css('background-image', 'linear-gradient( rgba(0,0,0,0.6), rgba(0,0,0,0))');
    });
});

/*---- Smooth scroll za sidra---*/

$(document).ready(function () {

    $(".smooth").on('click', function (event) {

        // menjamo default vrednost za scroll kada se klikne link
        if (this.hash !== "") {
            // sprecavanje default
            event.preventDefault();

            var hash = this.hash;

            // 800 - broj milisekundi za skrol
            // offset - 300 je pozicija na koju treba doci 
            var offset = $(hash).offset().top;
            $('html, body').animate({
                scrollTop: offset - 300
            }, 800, function () {});
        } 
    });


});

/*--- Menjamo css u odnosu na poziciju scroll-a ---*/
$(document).ready(function () {

    window.scrollTo(window.scrollX, window.scrollY - 1); // na pocetku pomerismo scroll da bi pokrenuli trigger i paginaciju
    window.scrollTo(window.scrollX, window.scrollY + 1);

    $(window).scroll(function () {
        
        scroll_Position = $(this).scrollTop();

        if (scroll_Position <= 50) {                    // u zavisnosti polozaja scroll-a menjamo css na elementima 

            $("#img1").css({"display": "none"});
            $("#img2").css({"display": "inline-block"});
            $("#two").removeClass("active-link");
            $("#three").removeClass("active-link");
            $("#four").removeClass("active-link");
            $("#five").removeClass("active-link");
            $("#six").removeClass("active-link");
        }else  if (scroll_Position > 50 && scroll_Position <= 150) {

            $("#img1").css({"display": "inline-block"});
            $("#img2").css({"display": "none"});
            $("#two").addClass("active-link");
            $("#three").removeClass("active-link");
            $("#four").removeClass("active-link");
            $("#five").removeClass("active-link");
            $("#six").removeClass("active-link");
        }else if (scroll_Position > 150 && scroll_Position < 450) {

            $("#img1").css({"display": "inline-block"});
            $("#img2").css({"display": "none"});
            $("#two").removeClass("active-link");
            $("#three").addClass("active-link");
            $("#four").removeClass("active-link");
            $("#five").removeClass("active-link");
            $("#six").removeClass("active-link");
        }else if (scroll_Position >= 450 && scroll_Position < 950) {

            $("#img1").css({"display": "inline-block"});
            $("#img2").css({"display": "none"});
            $("#two").removeClass("active-link");
            $("#three").removeClass("active-link");
            $("#four").addClass("active-link");
            $("#five").removeClass("active-link");
            $("#six").removeClass("active-link");
        }else if (scroll_Position >= 950 && scroll_Position < 1890) {

            $("#img1").css({"display": "inline-block"});
            $("#img2").css({"display": "none"});
            $("#two").removeClass("active-link");
            $("#three").removeClass("active-link");
            $("#four").removeClass("active-link");
            $("#five").addClass("active-link");
            $("#six").removeClass("active-link");
        }else if (scroll_Position >= 1890) {

            $("#img1").css({"display": "inline-block"});
            $("#img2").css({"display": "none"});
            $("#two").removeClass("active-link");
            $("#three").removeClass("active-link");
            $("#four").removeClass("active-link");
            $("#five").removeClass("active-link");
            $("#six").addClass("active-link");
        }
        
    });
});

// Timeline - menjamo sta se prikazuje od input boxova (popup boxovi)

$(function () {
    var inputs = $('.input');
   // var paras = $('.description-flex-container').find('p');
    $(inputs).hover(function () {
        var t = $(this);
               // ind = t.index(),
               // matchedPara = $(paras).eq(ind);

        $(t).addClass('active');
        $(inputs).not(t).removeClass('active');
    });
});
