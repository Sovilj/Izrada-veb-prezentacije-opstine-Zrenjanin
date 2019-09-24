/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*---- Navbar menja pozadinu kada se desi hover na megamenu----*/

$(function() {
  $(".megamenu").hover(function() {
    $(".navbar-background").css('background' , 'rgb(12,64,119)');
    
  }, function() {
    // reset pozadine
    
    $(".navbar-background").css('background', 'none');
    $(".navbar-background").css('background-image', 'linear-gradient( rgba(0,0,0,0.6), rgba(0,0,0,0))');
  });
});