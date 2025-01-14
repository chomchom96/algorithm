function solution(progresses, speeds) {
    var answer = [];
    let len = progresses.length;
    let time_taken = new Array(len);
    for (let i = 0; i < len; i++) {
        time_taken[i] = Math.ceil((100 - progresses[i]) / speeds[i]);
    };
    console.log(time_taken)
    let cnt = 1;
    let cur_max = time_taken[0];
    for (let i = 1; i < len; i++) {
        if (time_taken[i] > cur_max) {
            answer.push(cnt);
            cnt = 1;
            cur_max = time_taken[i];
        }
        else {
            cnt++
        }
    }
    answer.push(cnt);
    return answer;
}