"use client";
import {
    Button,
    Select,
    TextInput,
    useMantineColorScheme,
} from "@mantine/core";
import "@mantine/core/styles.css";
import "@mantine/tiptap/styles.css";

import { useEffect, useState } from "react";

import { RichTextEditor, Link } from "@mantine/tiptap";
import { IconColorPicker } from "@tabler/icons-react";
import Highlight from "@tiptap/extension-highlight";
import Placeholder from "@tiptap/extension-placeholder";
import { Color } from "@tiptap/extension-color";
import StarterKit from "@tiptap/starter-kit";
import Underline from "@tiptap/extension-underline";
import TextAlign from "@tiptap/extension-text-align";
import TextStyle from "@tiptap/extension-text-style";
import Superscript from "@tiptap/extension-superscript";
import { BubbleMenu, useEditor } from "@tiptap/react";
import SubScript from "@tiptap/extension-subscript";
import { useTheme } from "next-themes";
import toast from "react-hot-toast";
import axios from 'axios'


const CreatePage = () => {
    const { setTheme } = useTheme();
    const { colorScheme, setColorScheme } = useMantineColorScheme();
    const [category, setCategory] = useState(null);
    const [file, setFile] = useState("");

    const [title, setTitle] = useState(null);
    const [description, setDescription] = useState(null);

    const theme = colorScheme === "dark" ? "dark" : "light";

    let editor = useEditor({
        extensions: [
            StarterKit,
            Underline,
            Placeholder.configure({ placeholder: "Write article here..." }),
            Link,
            Superscript,
            SubScript,
            Highlight,
            TextStyle,
            Color,
            TextAlign.configure({ types: ["heading", "paragraph"] }),
        ],
        content: "",
    });

    function createSlug(title) {
        return title

            .toLowerCase()
            .replace(/[\s_]+/g, "-")
            .replace(/[^\w\-]+/g, "")
            .replace(/\-\-+/g, "-")
            .replace(/^-+/, "")
            .replace(/-+$/, "");
    }
    const handleSubmit = async () => {
        if (!file || !category || !title || !description) {
            toast.error("All fields are required");
            console.log("All fields are required");
            return;
        }
        const slug = createSlug(title);
        console.log(slug, title, category, file, description);
        console.log(editor.getHTML());

        const userIdRes = await axios.post("/api/users/checkCookies")
        const backendUrlres = await axios.get("/api/backendurl")
        const backendUrl = backendUrlres.data.data;
        const userId = userIdRes.data.data;


        const data = {
            "postTitle":title,
            "postContent":editor.getHTML(),
            "postDescription":description,
            "createdBy":userId,
        }
        const formData = new FormData();
        formData.append('image', file);
        formData.append('data', JSON.stringify(data));

        const response = await axios.post(backendUrl+"/post/", formData);
        console.log(response)


    };

    useEffect(() => {
        setTheme("light");
    },[])

    return (
        <>
            <div className="w-full p-4  justify-center items-center">
                <RichTextEditor editor={editor}>
                    <div className="w-full flex flex-col md:flex-row flex-wrap gap-5 mb-8">
                        <TextInput
                            withAsterisk
                            label="Post title"
                            className="w-full flex-1"
                            placeholder="Post title"
                            defaultValue={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                        <Select
                            withAsterisk
                            label="Category"
                            defaultValue={"Temples"}
                            placeholder="Pick Category"
                            data={[
                                "Technology",
                                "Science",
                                "Sports",
                                "Food",
                                "Travel",
                                "Artificial Intelligence",
                                "Cybersecurity",
                            ]}
                            onChange={(val) => setCategory(val)}
                        />
                    </div>
                    <div className="w-full flex flex-col md:flex-row flex-wrap gap-5 mb-8">
                        <label
                            className="flex items-center gap-1 justify-center text-base cursor-pointer "
                            htmlFor="imgUpload"
                        >
                            <input
                                type="file"
                                onChange={(e) => setFile(e.target.files[0])}
                                className="hidden"
                                id="imgUpload"
                                data-max-size="5120"
                                accept=".jpg, .png, .jpeg"
                            />

                            <span className="px-5 ml-3 rounded-lg border border-black">Post Image </span>
                            <div>{file ? `uploaded : ${file.name}` : ""}</div>
                        </label>
                    </div>
                    <div className="w-full flex flex-col md:flex-row flex-wrap gap-5 mb-8">
                    <TextInput
                            withAsterisk
                            label="Description"
                            className="w-full flex-1"
                            placeholder="Description"
                            defaultValue={description}
                            onChange={(e) => setDescription(e.target.value)}
                        />
                    </div>
                    {editor && (
                        <BubbleMenu editor={editor}>
                            <RichTextEditor.ControlsGroup>
                                <RichTextEditor.Bold />
                                <RichTextEditor.Italic />
                                <RichTextEditor.Link />
                            </RichTextEditor.ControlsGroup>
                        </BubbleMenu>
                    )}
                    <RichTextEditor.Toolbar sticky stickyOffset={20}>
                        <RichTextEditor.ColorPicker
                            colors={[
                                "#25262b",
                                "#868e96",
                                "#fa5252",
                                "#e64980",
                                "#be4bdb",
                                "#7950f2",
                                "#4c6ef5",
                                "#228be6",
                                "#15aabf",
                                "#12b886",
                                "#40c057",
                                "#82c91e",
                                "#fab005",
                                "#fd7e14",
                            ]}
                        />

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.Control interactive={true}>
                                <IconColorPicker size="1rem" stroke={1.5} />
                            </RichTextEditor.Control>
                            <RichTextEditor.Color color="#F03E3E" />
                            <RichTextEditor.Color color="#7048E8" />
                            <RichTextEditor.Color color="#1098AD" />
                            <RichTextEditor.Color color="#37B24D" />
                            <RichTextEditor.Color color="#F59F00" />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.UnsetColor />
                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.Bold />
                            <RichTextEditor.Italic />
                            <RichTextEditor.Underline />
                            <RichTextEditor.Strikethrough />
                            <RichTextEditor.ClearFormatting />
                            <RichTextEditor.Highlight />
                            <RichTextEditor.Code />
                            <RichTextEditor.CodeBlock />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.H1 />
                            <RichTextEditor.H2 />
                            <RichTextEditor.H3 />
                            <RichTextEditor.H4 />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.Blockquote />
                            <RichTextEditor.Hr />
                            <RichTextEditor.BulletList />
                            <RichTextEditor.OrderedList />
                            <RichTextEditor.Subscript />
                            <RichTextEditor.Superscript />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.Link />
                            <RichTextEditor.Unlink />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.AlignLeft />
                            <RichTextEditor.AlignCenter />
                            <RichTextEditor.AlignJustify />
                            <RichTextEditor.AlignRight />
                        </RichTextEditor.ControlsGroup>

                        <RichTextEditor.ControlsGroup>
                            <RichTextEditor.Undo />
                            <RichTextEditor.Redo />
                        </RichTextEditor.ControlsGroup>
                    </RichTextEditor.Toolbar>
                    <RichTextEditor.Content className="py-8" />
                </RichTextEditor>
                <div className="w-full flex items-end justify-end mt-6">
                    <Button
                        className="bg-blue-600 dark:bg-black"
                        onClick={() => handleSubmit()}
                    >
                        Submit post
                    </Button>
                </div>
            </div>
        </>
    );
};

export default CreatePage;
