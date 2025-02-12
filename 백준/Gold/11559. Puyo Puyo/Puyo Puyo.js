const input = require("fs").readFileSync("/dev/stdin").toString().trim().split('\n');

function calculateChain(board) {
    const row = 12;
    const col = 6;
    let chainCount = 0;
    
    function popPuyos(board) {
        const visited = Array(row).fill().map(() => Array(col).fill(false));
        let popped = false;
        
        // DFS로 같은 색 뿌요
        function dfs(r, c, color, group) {
            if (r < 0 || r >= row || c < 0 || c >= col) return;
            if (visited[r][c] || board[r][c] !== color) return;
            
            visited[r][c] = true;
            group.push([r, c]);
            
            dfs(r+1, c, color, group);
            dfs(r-1, c, color, group);
            dfs(r, c+1, color, group);
            dfs(r, c-1, color, group);
        }
        
        // 전체 보드 탐색
        for (let r = 0; r < row; r++) {
            for (let c = 0; c < col; c++) {
                if (board[r][c] !== '.' && !visited[r][c]) {
                    const group = [];
                    dfs(r, c, board[r][c], group);
                    
                    // 4개 이상 연결된 경우 터트리기
                    if (group.length >= 4) {
                        popped = true;
                        group.forEach(([r, c]) => {
                            board[r][c] = '.';
                        });
                    }
                }
            }
        }
        
        return popped;
    }
    
    // 중력 적용 함수
    function applyGravity(board) {
        for (let c = 0; c < col; c++) {
            let bottom = row - 1;
            for (let r = row - 1; r >= 0; r--) {
                if (board[r][c] !== '.') {
                    if (bottom !== r) {
                        board[bottom][c] = board[r][c];
                        board[r][c] = '.';
                    }
                    bottom--;
                }
            }
        }
    }
    
    let currentBoard = board.map(row => row.split(''));
    
    while (true) {
        const popped = popPuyos(currentBoard);
        if (!popped) break;
        
        chainCount++;
        applyGravity(currentBoard);
    }
    
    return chainCount;
}

console.log(calculateChain(input));