$(function () {
            $('#fullpage').fullpage({
                anchors: ['firstPage', 'secondPage', 'thirdPage', 'fourthPage', 'lastPage'],
                menu: '#myMenu',
                slidesNavigation: true,
                slidesNavPosition: 'bottom',
                continuousHorizontal:true,
                controlArrows: false,
                afterLoad: function (anchorLink, index) {
                    if (index > 1) {
                        $(".box").css('display', 'block');
                        $(".box > a span").css('background', 'grey');
                        $(".box > a:eq(" + (index - 2) + ") span").css('background', '#5FA429');
                    }
                    else {
                        $(".box > a span").css('background', 'grey');
                        $(".box").css('display', 'none');
                    }
                },
                loopBottom: true
            });
            //登录
            $('.getlogin').click(function () {
                $('.login_body').css('display', 'block');
                $('.login_main').addClass('addClass_login');
            })
            $('.quxiao').click(function () {
                $('.login_body').css('display', 'none');
            })       
            //右臂
            var time = null;
            $('.box').mouseenter(function () {
                time = clearTimeout();
                setTimeout(function () {
                    $('.box a').each(function (index, e) {
                        setTimeout(function () {
                            $(e).stop().animate({ right: 0 }, 200);
                        }, 50 * index)
                    })
                })
            }).mouseleave(function () {
                setTimeout(function () {
                    $('.box a').each(function (index, e) {
                        setTimeout(function () {
                            $(e).stop().animate({ right: -90 }, 200);
                        }, 50 * index)
                    })
                })
            })
            //轮播
            $(".cuboid").each(function (index, ele) {
                $(this).css({ "left": 200 * index, "transition-delay": index * 0.2 + "s" });
                $(this).children("div").css("backgroundPosition", -200 * index + "px");
            })
            var num = 0;
            $(".next").on("click", function () {
                num++;
                $(".cuboid").css("transform", "rotateX(" + num * 90 + "deg)");
            })
            $(".prev").on("click", function () {
                num--;
                $(".cuboid").css("transform", "rotateX(" + num * 90 + "deg)");
            })
            var flag = true;
            $('.center').mouseenter(function () {
                flag = false;
            })
            $('.center').mouseleave(function () {
                flag = true;
            })
            var timer = setInterval
            timer(function(){
                if (flag) {
                    $(".next").click();
                }
                else {
                    return true;
                }
            }, 5000)
            //轮播二
            function imgin() {
                $(lefts[s3_index]).delay(1000).slideLeftShow(1000);
                $(rights[s3_index]).delay(1000).slideRightShow(1000);
            }
            function imgout() {
                $(lefts[s3_index]).slideLeftHide(1000);
                $(rights[s3_index]).slideRightHide(1000);
            }
            var lefts = $('#s3 .left');
            var rights = $('#s3 .right');
            var s3_len = $('#s3 .port').length;
            var s3_index = 0;
            var go = null;
            (function autoPlay() {
                go = clearInterval();
                imgin();
                function play() {                    
                    if (s3_index >= 0 && s3_index < s3_len - 1 ) {
                        imgout();
                        s3_index++;
                        imgin();
                    }
                    else {
                        imgout();
                        s3_index = 0;
                        imgin();
                    };
                }
                setInterval(play, 5000);
            })()
            //轮播三
            var items = $('.video');
            var len = items.length;
            var index = 0;            
            (function autoPlay() {
                $(items[index]).fadeIn(1000);
                function play() {
                    if (index >= 0 & index < len - 1) {
                        $(items[index]).fadeOut(1500);
                        index++;
                        $(items[index]).fadeIn(1500);
                    } else {
                        $(items[index]).fadeOut(1500);
                        index = 0;
                        $(items[index]).fadeIn(1500);
                    };
                }
                setInterval(play, 4000);
            })()
        })