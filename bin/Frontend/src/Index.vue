<template>
    <div>
        <div class="header-section">
          <br>
        <h2 class="main-header" style="font-family:arial"> <strong>Supermercado </strong></h2>
        </div>
        <div class="body-section">
            <br>
            <div id="main_area">
                <div class="col-sm-12" id="slider">
                 <div class="row">
                    <div class="col-sm-12 col-md-10" id="carousel-bounding-box">
                        <div class="carousel slide" id="myCarousel" data-ride="carousel">
                            <!-- Carousel items -->
                            <div class="carousel-inner">
                                <div class="carousel-item active" data-slide-number="0">
                                    <img src="./img/imagen1.png"></div>
                                <div class="carousel-item" data-slide-number="1">
                                    <img src="./img/maxresdefault.png"></div>

                            </div>
                            <!-- Carousel nav -->
                            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                                <div class="carousel-control-circle"><span class="carousel-control-prev-icon" aria-hidden="true"></span></div>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                                <div class="carousel-control-circle"><span class="carousel-control-next-icon" aria-hidden="true"></span></div>
                                <span class="sr-only">Previous</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <!--/Slider-->
          </div>
        </div>
    </div>
</template>

<script>
    export default{
        data(){
            return{
            title:'Index'
            }
        },
        mounted: function(){
            $('#myCarousel').carousel({
                interval: 10000
            });
            $('#carousel-text').html($('#slide-content-0').html());
            // When the carousel slides, auto update the text
            $('#myCarousel').on('slid.bs.carousel', function (e) {
                var id = $('#myCarousel .active').index('#myCarousel .carousel-item');
                $('#carousel-text').html($('#slide-content-'+id).html());
            });
        }
    }
</script>

<style>
    .main-header{
        font-family: 'Poppins', arial;
        font-size: 50px;
        color: #000000;
    }
    #main_area{
        background-color: ghostwhite;
        width: 100%;
        overflow: auto;
    }
    #carousel-bounding-box{
        height: 500px;
        width: 700px;
        padding: 0;
        border: 2px black;
    }
    #carousel-text{
      padding: 10px;
    }
    .carousel-item img{
        height: 100%;
        width: auto;
    }
    .carousel-control-circle{
        display: block;
        width: 30px;
        height: 30px;
        padding-top: 5px;
        background: rgba(0,0,0,0.9);
        border: 3px white;
        border-radius: 50%;
    }
    .main-heading {
        text-align: center;
        color: black;
        padding: 6vh;
    }
    .main-heading *{
        text-transform: none;
    }
</style>
