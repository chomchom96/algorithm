const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];
let row = 0;
let col = 0;
let visited;
let acc;

function bfs(r, c, land) {
    const queue = [];
    visited[r][c] = true;
    queue.push([r, c]);
    let cnt = 0;
    let start = c;
    let end = c;

    while (queue.length > 0) {
        const [cr, cc] = queue.shift();
        cnt++;
        start = Math.min(start, cc);
        end = Math.max(end, cc);
        
        for (let i = 0; i < 4; i++) {
            let nr = cr + dr[i];
            let nc = cc + dc[i];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && land[nr][nc] === 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                queue.push([nr, nc]);
            }
        }
    }
    
    acc[start] += cnt;
    acc[end + 1] -= cnt;
}

function solution(land) {
    row = land.length;
    col = land[0].length;
    visited = Array.from({length: row}, () => Array(col).fill(false));
    acc = new Array(col + 1).fill(0);
    
    for (let r = 0; r < row; r++) {
        for (let c = 0; c < col; c++) {
            if (land[r][c] === 1 && !visited[r][c]) {
                bfs(r, c, land);
            }
        }
    }

    let answer = acc[0];
    for (let i = 1; i < col; i++) {
        acc[i] += acc[i - 1];
        answer = Math.max(answer, acc[i]);
    }

    return answer;
}