(ns day5
  (:require [clojure.string :as str]))

(defn parse-stack [lines]
  (->> (str/split-lines lines)
       (apply mapv str)
       (mapv #(re-find #"[A-Z]+" %))
       (filter some?)
       (mapv #(apply list %))
       (concat '(()))
       vec))

(defn parse-moves [lines]
  (->> (str/split-lines lines)
       (mapv #(zipmap [:n :from :to]
                      (mapv parse-long (re-seq #"\d+" %))))))

;; part 1
(defn move1 [stacks {from :from to :to n :n}]
  (assoc stacks
         from (drop n (stacks from))
         to (into (stacks to) (take n (stacks from)))))

(let [input (str/split (slurp "day5.input.txt") #"\n\n")
      stacks (parse-stack (first input))
      moves (parse-moves (second input))]
  (->> (reduce move1 stacks moves)
       (map first)
       (apply str)))
;; => "VGBBJCRMN"

;; part 2
(defn move2 [stacks {from :from to :to n :n}]
  (assoc stacks
         from (drop n (stacks from))
         to (into (stacks to) (reverse (take n (stacks from))))))

(let [input (str/split (slurp "day5.input.txt") #"\n\n")
      stacks (parse-stack (first input))
      moves (parse-moves (second input))]
  (->> (reduce move2 stacks moves)
       (map first)
       (apply str)))
;; => "LBBVJBRMH"
