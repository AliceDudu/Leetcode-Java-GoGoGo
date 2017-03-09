
public String licenseKeyFormatting(String S, int K) {
    
//     把符号去掉，变成大写
    S = S.replaceAll("[-]", "");
    S = S.toUpperCase();

    StringBuilder sb = new StringBuilder();
    sb.append(S);

    int i = sb.length() - K;
    
//     从后向前，每隔k个在sb中插入符号
    while(i > 0) {
        sb.insert(i, '-');
        i = i - K;
    }

    return sb.toString();
}