(function($){
    var toolBar;
    window.mapInstance = new AMap.Map("map",{
        rotateEnable:true,
        dragEnable:true,
        zoomEnable:true,
        zooms:[3,18],
        //二维地图显示视口
        view: new AMap.View2D({
            center:new AMap.LngLat(116.397428,39.90923),//地图中心点
            zoom:13 //地图显示的缩放级别
        })
    });


    window.expandCollapse = function (target) {
        $target = $(target);
        $target.toggle("slow");
    }

    //获得所有的好友
    $.getJSON("/relationship?userId="+USERID,function(data){
        window._FRIENDS = data;
        updateFriendsList(data);
    });

    var updateFriendsList = function(l){
        var $friends = $("#friends");
        $friends.empty();
        $.each(l,function(i,n){
            $friends.append('<li><div class="photo pull-left"><img src="'+ n.photo +'"></div><span class="name">'+n.nickname+'</span></li>');
            l.interval = setInterval(function(){

            },60000)
        })
    }

    window.getUserPosition = function(user){
//        return $.getJSON("/position?userId="+ n.id, function (data) {
//            n.position = data;
//            showUserPosition(n);
//        })
        return $.getJSON("/position?userId"+ user.id)
    }
    window.showUserPosition = function(user){
        var marker = user.marker;
        if(!marker) {
            user.marker = new AMap.Marker({
                icon: user.photo,
                position: new AMap.LngLat(user.position.lng, user.position.lat)
            });
            marker.setMap(window.mapInstance);  //在地图上添加点
        }else{
            marker.setPosition(new AMap.LngLat(user.lng,user.lat));
        }

    }
})(jQuery);