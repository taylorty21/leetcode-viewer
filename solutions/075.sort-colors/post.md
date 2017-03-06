## Solution 1:counting sort
从左到右数一下有多少0， 1， 2。然后在数组里写相应个数的0，1，2.
```
void sortColors(vector<int>& nums) {
    int count[3] = {0, 0, 0};
    for (int k = 0; k < nums.size(); ++k) count[nums[k]]++;

    int l = 0;
    for (int k = 0; k < 3; ++k) {
        for (int j = 0; j < count[k]; ++j, ++l) nums[l] = k;
    }
}
```

## Solution 2: partition
作两次partition，一次把0放在数组左边，第二次把2放在数组右边。
```
 public void sortColors(int[] nums) {
    int one = 0, two = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            swap(nums, i, one);
            one++;
        }
    }
    
    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] == 2) {
            swap(nums, i, two);
            two--;
        }
    }
}
public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
```
更简短的1-pass实现：这里我们把两个partition合并到一起，但需要注意由于归并到右边是从左到右扫描的，因此swap到位置k的是一个未检查过的元素，因此需要检查它是否为0.
```
for (int k = 0, left = 0, right = nums.size()-1; k < nums.size(); ++k) {
    while (nums[k] == 2 && k < right) swap(nums[k], nums[right--]);
    while (nums[k] == 0 && k > left ) swap(nums[k], nums[left++]);
}
```
