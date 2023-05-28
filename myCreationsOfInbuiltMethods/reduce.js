// jai Ganesh
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = (nums, fn, init) => {
   if(nums.length === 0) return init; 
   else{
     const newArr = nums.slice(1,); // create reduced array
     let val = fn(init, nums[0]); // apply function to accumulated value (init initially), now new accumulator is val
     return reduce(newArr, fn, val); // recursively call reduce with new Reduced array, function(fn) and accumulated value;
   } 
}

