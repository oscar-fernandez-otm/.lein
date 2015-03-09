(require '[vinyasa.inject]
         '[spyscope.core]
         '[clojure.test :as t])

(ns user) ;; needed in order vinyasa.inject doesn't fail
(vinyasa.inject/inject '[clojure.core - [clojure.repl apropos dir doc find-doc source pst root-cause]])

(vinyasa.inject/inject '[clojure.core - [clojure.java.javadoc javadoc]])

(vinyasa.inject/inject '[clojure.core - [clojure.pprint pprint]])

(try ;; try to inject logging functions, may not be loaded
  (require 'clojure.tools.logging)
  (vinyasa.inject/inject '[clojure.core - [clojure.tools.logging info warn error]])
  (catch Exception e
    (.printStackTrace e)))
