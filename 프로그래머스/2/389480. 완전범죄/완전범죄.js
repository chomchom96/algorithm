function solution(info, n, m) {
  const MAX = 120 + 12;
  const itemCnt = info.length;
  
  let dp = Array(MAX).fill().map(() => Array(MAX).fill(false));
  dp[0][0] = true;
  
  for (let i = 0; i < itemCnt; i++) {
    let nextDp = Array(MAX).fill().map(() => Array(MAX).fill(false));
    const traceA = info[i][0];
    const traceB = info[i][1];
    
    for (let a = 0; a < n; a++) {
      for (let b = 0; b < m; b++) {
        if (!dp[a][b]) {
          continue;
        }
        
        if (a + traceA < n) {
          nextDp[a + traceA][b] = true;
        }
        
        if (b + traceB < m) {
          nextDp[a][b + traceB] = true;
        }
      }
    }
    
    dp = nextDp.map(row => [...row]);
  }
  
  for (let a = 0; a < n; a++) {
    for (let b = 0; b < m; b++) {
      if (dp[a][b]) {
        return a;
      }
    }
  }
  
  return -1;
}
