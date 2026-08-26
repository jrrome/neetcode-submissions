class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        ordered = nums.sort()
        for index, item in enumerate(nums[:-1]):
            if item == nums[index + 1]: return True
        return False