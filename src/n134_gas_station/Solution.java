package n134_gas_station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas.length == 0) return -1;
        int[] stationGain = new int[gas.length];
        int i = 0, startingStation = gas.length - 1, remainingGas = 0;
        for(i = 0; i < gas.length; i++)
        	stationGain[i] = gas[i] - cost[i];
        remainingGas = stationGain[startingStation];
        i = 0;
        while(i < startingStation){
        	while(i < startingStation && remainingGas >= 0){
        		remainingGas += stationGain[i];
        		i++;
        	}
        	while(i < startingStation && remainingGas < 0){
        		startingStation--;
        		remainingGas += stationGain[startingStation];
        	}
        }
        if(remainingGas >= 0) return startingStation;
        return -1;
    }
}