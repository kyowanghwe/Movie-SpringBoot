var vid = $("#video")[0];
const forward = 30;
const backward = -30;
var time = 0;

$("#skip").click(function () {
    time = vid.currentTime;
    time += forward;
    skipTime(time);
    console.log(time);
});

$("#back").click(function () {
    time = vid.currentTime;
    time += backward;
    skipTime(time);
    console.log(time);
});

function skipTime(time) {
    vid.play();
    vid.pause();
    vid.currentTime = time;
    vid.play();
};