public class BloomFilter
{
    public int filter_len;
    private int bitFilter;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitFilter = 0;
    }

    public int hash1(String str1)
    {
        int hash = 0;
        for(int i = 0; i < str1.length(); i ++)
        {
            int code = (int)str1.charAt(i);
            hash = hash * 17 + code;
        }
        return hash % filter_len;
    }
    public int hash2(String str1)
    {
        int hash = 0;
        for(int i = 0; i < str1.length(); i ++)
        {
            int code = (int)str1.charAt(i);
            hash = hash * 223 + code;
        }
        return hash % filter_len;
    }

    public void add(String str1)
    {
        int bitHash1 = hash1(str1);
        int bitHash2 = hash2(str1);
        bitFilter = (bitFilter | (1 << bitHash1)) | (bitFilter | (1 << bitHash2));
    }

    public boolean isValue(String str1)
    {
        int bitHash1 = hash1(str1);
        int bitHash2 = hash2(str1);
        return ((bitFilter & (1 << bitHash1)) != 0) && ((bitFilter & (1 << bitHash2)) != 0);
    }
}