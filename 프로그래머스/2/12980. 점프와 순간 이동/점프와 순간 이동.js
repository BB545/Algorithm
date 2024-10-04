function solution(n)
{
    let battery = 0;
    
    while (n > 0) {
        if (n % 2 === 1) {
            n -= 1;
            battery += 1;
        }
        
        n = Math.floor(n / 2);
    }
    
    return battery;
}