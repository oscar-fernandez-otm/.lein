(require '[vinyasa.inject]
         '[spyscope.core]
         '[clojure.test :as t]
         '[slam.hound :refer [reconstruct swap-in-reconstructed-ns-form]])

(ns user) ;; needed in order vinyasa.inject doesn't fail
(vinyasa.inject/inject 'clojure.core '-
                       '[[slam.hound reconstruct swap-in-reconstructed-ns-form]
                         [clojure.repl apropos dir doc find-doc source pst root-cause]
                         [clojure.java.javadoc javadoc]

                         [clojure.pprint pprint]])
