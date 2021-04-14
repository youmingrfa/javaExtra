package LintCode;

import java.sql.Array;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.Math.*;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1])    return true;
        }
        return false;
    }

}
