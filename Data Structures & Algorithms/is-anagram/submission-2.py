class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        smap = {}
        tmap = {}
        for c in s:
            if not c in smap: smap[c] = 1
            else: smap[c] = smap[c] + 1
        for c in t:
            if not c in tmap: tmap[c] = 1
            else: tmap[c] = tmap[c] + 1
        for c in s + t:
            if not c in smap or not c in tmap or smap[c] != tmap[c]: return False
        return True

        
        
