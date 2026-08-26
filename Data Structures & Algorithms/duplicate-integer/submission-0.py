class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        for index, item in enumerate(nums):
            if nums[index:].count(item) > 1: return True
        return False