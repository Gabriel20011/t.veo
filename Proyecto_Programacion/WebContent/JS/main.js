$(document).ready(function(){

    $('#button-menu').click(function(){

        if($('#button-menu').attr('class')== 'fa fa-bars'){
            $('#button-menu').removeClass('fa fa-bars').addClass('fa fa-close');
            $('.navegacion .menu').css({'left': '0px'});
            $('.navegacion').css({'width':'100%', 'background':'rgba(0,0,0,.5)'});
        }else{
            $('#button-menu').removeClass('fa fa-close').addClass('fa fa-bars');
            $('.navegacion .menu').css({'left':'-320px'});
            $('.navegacion').css({'width':'0%', 'background':'rgba(0,0,0,.0)'}); // Ocultamos el fonto transparente

        }
    });


});