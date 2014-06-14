{:user {:dependencies [
                       [clj-stacktrace "0.2.7"]
                       [slamhound "1.5.0"]
                       [com.cemerick/pomegranate "0.2.0"]
                       [im.chit/vinyasa "0.1.2"]
                       [org.clojure/tools.namespace "0.2.5-SNAPSHOT"]
                       [spyscope "0.1.4"]
                       ]
        :repositories {"sonatype-oss-public"
               "https://oss.sonatype.org/content/groups/public/"}
        :plugins [[lein-difftest "2.0.0"]
                  [com.cemerick/austin "0.1.5-SNAPSHOT"]
                  #_[cider/cider-nrepl "0.7.0-SNAPSHOT"]
                  [lein-marginalia "0.7.1"]
                  [lein-simpleton "1.3.0"]]
        :repl-options {
                       :init
                       (load-file (str
                                   (System/getProperty "user.home")
                                   "/.lein/user.clj"))}
        :injections [(require 'spyscope.core)
                     (let [orig (ns-resolve (doto 'clojure.stacktrace require)
                                            'print-cause-trace)
                           new (ns-resolve (doto 'clj-stacktrace.repl require)
                                           'pst)]
                       (alter-var-root orig (constantly (deref new))))]}}





