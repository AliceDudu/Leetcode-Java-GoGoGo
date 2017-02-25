

10个为一段尺子，一个一个向右走
seen set里没有的，就加进去
seen set里有了，就加到repeated里去

public List<String> findRepeatedDnaSequences(String s) {

    Set seen = new HashSet();
    Set repeated = new HashSet();
    
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        
//         if ( !seen.add(ten) ){
//             repeated.add(ten);
//         }
//         和上面代码一个意思
        if ( !seen.contains(ten) ){
            seen.add(ten);
        }else{
            repeated.add(ten);           
        }
    }
    
    return new ArrayList(repeated);
}