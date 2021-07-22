package com.company;

/*public class RateLimiter {
    Redis redisClient;
    int callsAllowedInTimeFrame = 10;
    int timeframeInSec = 60;
    public RateLimiter(){
        // key would be api key and value will be list of timeframes
        //inititalize redis instance with name and host
    }

    public void isViolating(String apiKey,int callsAllowedInTimeFrame,int timeframeInSec,Request rq){
       List<Timeframe> list =  redisClient.get(apiKey);
       int currentTime  = rq.getTimeframe(); // System will return current timestamp
        int count = 0;
        //running a loop to check how many timestamps are stored within last minute
        //so the idea is if i get more than 10 timeframes from current time then I will block the user else
        // will let user to continue;
        if(list.size() == 0 || list.size() < MaxSize){
            redisClient.put(apiKey,list.add(currentTime));
        }
        int num = getTimeframesforLastMinute(currentTime);
        if(num > callsAllowedInTimeFrame){
            //block the user
        }else{
            //push timeframe int the list and update redis
            list.add(currentTime);
            redisClient.put(apikey,list);
        }
        //this method will remove the timeframes older than last minute
        removeTimeframesBeforeLastMinute(apiKey,currentTime);
    }

}*/
