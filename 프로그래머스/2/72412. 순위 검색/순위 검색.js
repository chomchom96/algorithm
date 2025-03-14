function solution(infos, querys) {
   const map = new Map();
   
   infos.forEach(v => {
       const info = v.split(' ');
       const score = Number(info.pop());
       
       let key = info.join('');
       map.set(key, map.has(key) ? [...map.get(key), score] : [score]);
   });
   
   for(let [k, v] of map) {
       map.set(k, v.sort((a, b) => a - b));
   }
   
   return querys.map(q => {
       const conds = q.split(/ and | |-/i).filter(e => e);
       return search(map, conds);
   });
}

const search = (map, conds) => {
   const score = Number(conds.pop());
   
   return Array.from(map.keys())
       .filter(k => conds.every(c => k.includes(c)))
       .reduce((sum, k) => sum + map.get(k).slice(lowerBound(map.get(k), score)).length, 0);
}

const lowerBound = (arr, target) => {
   let l = 0;
   let r = arr.length; 
   while(l < r) {
       const m = Math.floor((l + r) / 2);
       if(arr[m] >= target) r = m;
       else l = m + 1;
   }
   return l;
}