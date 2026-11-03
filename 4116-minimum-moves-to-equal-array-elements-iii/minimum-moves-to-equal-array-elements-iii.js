var minMoves = function(nums) {
    const mx = Math.max(...nums);
    let res = 0;
    for (const x of nums) {
        res += mx - x;
    }
    return res;
};