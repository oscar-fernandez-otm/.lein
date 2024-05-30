{:user {:plugins [[lein-difftest "2.0.0"]
                  [lein-pprint "1.3.2"]]
        :dependencies [[borkdude/edamame "1.4.25" :exclusions [org.clojure/tools.reader]]
                       [clj-kondo "2024.03.05" :exclusions [com.cognitect/transit-clj com.cognitect/transit-java cheshire org.clojure/tools.reader ]]]
        :aliases {"clj-kondo" ["run" "-m" "clj-kondo.main"]}}
 :repl {:pedantic? :warn

        :dependencies [;; banners
;;                        [org.bouncycastle/bcprov-jdk15on "1.59"]
                       ;; expert
                       ;;                      [org.bouncycastle/bcprov-jdk15on "1.48"]

                       [vvvvalvalval/scope-capture "0.3.2"]
                       #_[org.opensaml/xmltooling "1.4.4"]
                       #_[net.java.dev.jna/jna "4.2.2"]
                       #_[net.cgrand/macrovich "0.2.1"]
                       [potemkin "0.4.5"]
                       ;;[zcaudate/lucid "1.4.7" :exclusions [org.bouncycastle/bcprov-jdk15on zcaudate/lucid.package zcaudate/lucid.web]]
                       [org.clojure/tools.reader "1.4.0"]
                       [org.clojure/core.rrb-vector "0.2.0"]
                       [spyscope "0.1.7-SNAPSHOT" :exclusions [org.clojure/tools.reader org.clojure/clojure org.clojure/clojurescript org.clojure/core.rrb-vector]] ;; need to install locally
                       #_[com.google.errorprone/error_prone_annotations "2.1.3"]
                       #_[com.google.guava/guava "25.1-jre" :exclusions [com.google.code.findbugs/jsr305]]
                       #_[com.google.protobuf/protobuf-java "3.0.2"]
                       #_[org.clojure/tools.logging "0.4.1"]
                       [nrepl "1.1.1"]
                       #_[cljs-analyzer "0.1.0-SNAPSHOT"]
                       [cider/piggieback "0.5.3"]

                       [criterium "0.4.4"]]
        :plugins [[cider/cider-nrepl "0.47.0"]

                  [refactor-nrepl "3.10.0" :exclusions [org.clojure/clojure nrepl]]]
        :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]
                       :init              (load-file (str
                                                      (System/getProperty "user.home")
                                                     "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (require 'sc.api)]}}
