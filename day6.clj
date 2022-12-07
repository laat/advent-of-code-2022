(ns day6)

 ;"bvwbjplbgvbhsrlpgdmjqwftvncz"
 ;"nppdvjthqldpwncqszvftbrmjlhg"
 ;"nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
 ;"zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

(->>
 (slurp "day6.input.txt")
 (partition 4 1)
 (take-while #(not (apply distinct? %)))
 (count)
 (+ 4))
;; => 1929

(->>
 (slurp "day6.input.txt")
 (partition 14 1)
 (take-while #(not (apply distinct? %)))
 (count)
 (+ 14))
;; => 3298
