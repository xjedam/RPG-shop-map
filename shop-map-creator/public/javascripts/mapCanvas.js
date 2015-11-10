$(function() {
    var canvasApp = function(){
        var app = {};
        app.id = "";
        app.background;
        app.context;

        app.init = function(id, background) {
            app.id = id;
            app.background = background;
            var theCanvas = document.getElementById(id);
            app.context = theCanvas.getContext("2d");

        };

        app.draw = function() {
            if(app.background) {
                app.context.drawImage(app.background, 0, 0);
            }

           /* context.fillStyle = '#aaaaaa';
            context.fillRect(0, 0, 200, 200);
            context.fillStyle = '#000000';
            context.font = '20px sans-serif';
            context.textBaseline = 'top';
            context.fillText("Canvas!", 0, 0);*/
        };

        return app;
    };

    window.canvasApp = canvasApp();
});

function unescapeHtml(safe) {
    return safe.replace(/&amp;/g, '&')
        .replace(/&lt;/g, '<')
        .replace(/&gt;/g, '>')
        .replace(/&quot;/g, '"')
        .replace(/&#039;/g, "'");
}


