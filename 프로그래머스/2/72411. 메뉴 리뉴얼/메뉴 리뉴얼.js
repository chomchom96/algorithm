function solution(orders, course) {
    const answer = [];
    
    const sortedOrders = orders.map(order => 
        order.split('').sort().join('')
    );
    
    // 각 코스 길이에 대해 가능한 조합을 찾음
    course.forEach(size => {
        const combinations = new Map();
        
        // 각 주문에 대해 가능한 조합을 생성
        sortedOrders.forEach(order => {
            // size 길이의 모든 조합 생성
            getCombinations(order, size).forEach(combo => {
                // 해시맵에 조합 횟수 증가
                combinations.set(combo, (combinations.get(combo) || 0) + 1);
            });
        });
        
        if (combinations.size === 0) return;
        
        // 가장 많이 주문된 횟수 찾기
        let maxCount = 2; // 최소 2번 이상 주문된 것만 고려
        combinations.forEach((count) => {
            maxCount = Math.max(maxCount, count);
        });
        
        // 최대 주문 횟수가 2 미만이면 다음 코스 크기로 넘어감
        if (maxCount < 2) return;
        
        // 가장 많이 주문된 조합들을 결과에 추가
        combinations.forEach((count, combo) => {
            if (count === maxCount) {
                answer.push(combo);
            }
        });
    });
    
    // 결과를 사전순으로 정렬
    return answer.sort();
}

function getCombinations(str, size) {
    const results = [];
    
    function backtrack(start, current) {
        if (current.length === size) {
            results.push(current);
            return;
        }
        
        for (let i = start; i < str.length; i++) {
            backtrack(i + 1, current + str[i]);
        }
    }
    
    backtrack(0, '');
    return results;
}