for f in $(find "$PWD" | grep .class);
do
	rm "$f"
done
