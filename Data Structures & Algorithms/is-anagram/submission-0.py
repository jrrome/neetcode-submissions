class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        ss = list(s)
        st = list(t)
        ss.sort()
        st.sort()
        if ss == st: return True
        return False
        
