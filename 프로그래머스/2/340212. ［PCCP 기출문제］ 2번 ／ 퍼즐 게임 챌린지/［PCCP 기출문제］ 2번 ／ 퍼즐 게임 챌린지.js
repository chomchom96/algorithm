function isImpossible(diffs, times, level, limit) {
    let tmp = times[0];

    for (let i = 1; i < diffs.length; i++) {
        if (diffs[i] > level) {
            tmp += (diffs[i] - level) * (times[i-1] + times[i]);
        }
        tmp += times[i];
    }
    return limit < tmp;
}

function solution(diffs, times, limit) {
 let left = 1;
    let right = limit;

    while (left < right) {
        let mid = Math.floor((left + right) / 2);

        if (isImpossible(diffs, times, mid, limit)) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}
