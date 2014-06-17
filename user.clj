(require '[cemerick.pomegranate :as pomegranate]
         '[cemerick.austin.repls :as repls]
         '[cemerick.austin]
         '[vinyasa.lein :refer [lein]]
         '[vinyasa.inject]
         '[clojure.tools.namespace.repl :refer [refresh]]
         '[spyscope.core]
         '[clojure.test :as t])


(defn add-dependencies [& coordinates]
  (pomegranate/add-dependencies
   :coordinates (map #(cond
                       (not (sequential? %)) [(symbol %) "RELEASE"]
                       :else `[~(-> % first symbol) ~@(or (next %)
                                                         ["RELEASE"])])
                     coordinates)
   :repositories (merge cemerick.pomegranate.aether/maven-central
                        {"clojars"
                         "http://clojars.org/repo"
                         "sonatype-oss-public"
                         "https://oss.sonatype.org/content/groups/public/"})))

(ns user) ;; needed in order vinyasa.inject doesn't fail
(vinyasa.inject/inject 'clojure.core '-
                       '[[user add-dependencies]
                         [clojure.tools.namespace.repl refresh]
                         [clojure.repl apropos dir doc find-doc source pst root-cause]
                         [clojure.java.javadoc javadoc]

                         [clojure.pprint pprint]])

(defn austin-phantomjs [& args]
  (apply repls/exec :exec-cmds ["phantomjs"] args))

(defn austin-chrome [& args]
  (apply repls/exec :exec-cmds ["chromium-browser"] args))

(defn austin-setup-browser-repl [& args]
  (reset! repls/browser-repl-env
          (apply cemerick.austin/repl-env args))
  (repls/browser-connected-repl-js))

(defn austin-browser-repl [& args]
  (when-not @repls/browser-repl-env
    (apply austin-setup-browser-repl args))
  (repls/cljs-repl @repls/browser-repl-env))
