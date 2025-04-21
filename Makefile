.PHONY:	help test
help:
	@echo "usage: make <option>"
	@echo "options and effects:"
	@echo "    help                     : Show help"
	@echo "    test                     : Test ..."
	@echo "    push                     : Push Code ..."

test:
	@echo "test ..."

.PHONY:	push upgrade
push:
	@git add .
	git commit -m "自动脚本 push"
	git push origin main
