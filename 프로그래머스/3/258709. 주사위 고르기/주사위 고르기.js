

function getCombinations(array, size) {
    const result = [];
    
    function combine(start, current) {
        if (current.length === size) {
            result.push([...current]);
            return;
        }
        
        for (let i = start; i < array.length; i++) {
            current.push(array[i]);
            combine(i + 1, current);
            current.pop();
        }
    }
    
    combine(0, []);
    return result;
}


function calculateAllSums(dice, indices) {
    const sumCounts = new Map();
    
    function dfs(idx, currentSum) {
        if (idx === indices.length) {
            sumCounts.set(currentSum, (sumCounts.get(currentSum) || 0) + 1);
            return;
        }
        
        const diceIdx = indices[idx];
        for (const face of dice[diceIdx]) {
            dfs(idx + 1, currentSum + face);
        }
    }
    
    dfs(0, 0);
    return Array.from(sumCounts.entries());
}

function solution(dice) {
    const n = dice.length;
    const half = n / 2;
    
    const combinations = getCombinations([...Array(n).keys()].map(i => i + 1), half);
    
    let maxWinRate = -1;
    let bestCombination = [];
    
    for (const combA of combinations) {
        const combB = [...Array(n).keys()].map(i => i + 1).filter(num => !combA.includes(num));
        
        const aIndices = combA.map(i => i - 1);
        const bIndices = combB.map(i => i - 1);
        
        const aSums = calculateAllSums(dice, aIndices);
        const bSums = calculateAllSums(dice, bIndices);
        
        let wins = 0;
        let total = 0;
        
        for (const [sumA, countA] of aSums) {
            for (const [sumB, countB] of bSums) {
                const cases = countA * countB;
                if (sumA > sumB) wins += cases;
                total += cases;
            }
        }
        
        const winRate = wins / total;
        
        if (winRate > maxWinRate) {
            maxWinRate = winRate;
            bestCombination = [...combA];
        }
    }
    
    return bestCombination;
}


