(function($){
    var toolBar;
    window.mapInstance.plugin(["AMap.ToolBar"],function(){
        toolBar = new AMap.ToolBar(); //设置地位标记为自定义标记
        window.mapInstance.addControl(toolBar);
        AMap.event.addListener(toolBar,'location',function callback(e){
            var lnglat = e.lnglat;
            $.post("/position/save",{lng:lnglat.lng,lat:lnglat.lat},function(){
                console.log(arguments)
            })
        });

        setInterval(function(){
            toolBar.doLocation();
        },60000);
    });

})(jQuery);
